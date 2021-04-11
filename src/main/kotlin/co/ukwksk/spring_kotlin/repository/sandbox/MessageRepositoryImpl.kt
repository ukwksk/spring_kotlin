package co.ukwksk.spring_kotlin.repository.sandbox

import co.ukwksk.spring_kotlin.entity.sandbox.SandboxMessage
import co.ukwksk.spring_kotlin.elasticsearch.sandbox.MessageSchema
import mbuhot.eskotlin.query.term.match_all
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.get.GetRequestBuilder
import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.index.query.IdsQueryBuilder
import org.elasticsearch.search.SearchHit
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.springframework.stereotype.Repository

@Repository
class MessageRepositoryImpl(
    private val esClient: RestHighLevelClient
) : MessageRepository {

    companion object {
        val INDEX_NAME = "sandbox-message-index"
    }

    override fun listAll(): List<SandboxMessage> =
        SearchRequest(INDEX_NAME).also {
            it.source(
                SearchSourceBuilder.searchSource().query(
                    match_all { }
                )
            )
        }.let {
            esClient.search(it, RequestOptions.DEFAULT).hits.hits
        }.map {
            MessageSchema(
                it.id,
                it.sourceAsMap.getValue("message") as String,
            )
        }.map {
            SandboxMessage.fromSchema(it)
        }

    override fun saveMessage(message: SandboxMessage): SandboxMessage =
        MessageSchema.fromEntity(message).also { schema ->
            IndexRequest(INDEX_NAME).also {
                it.id(schema.id)
                it.source(schema.asMap())
            }.also {
                esClient.index(it, RequestOptions.DEFAULT)
            }
        }.let {
            SandboxMessage.fromSchema(it)
        }

    override fun findBy(spec: MessageSpec): SandboxMessage? =
        spec.id?.let { id ->
            GetRequest(INDEX_NAME).also {
                it.id(id.stringValue())
            }
        }?.let {
            esClient.get(it, RequestOptions.DEFAULT)
        }?.let {
            MessageSchema(
                it.id,
                it.sourceAsMap.getValue("message") as String,
            )
        }?.let {
            SandboxMessage.fromSchema(it)
        }
}
