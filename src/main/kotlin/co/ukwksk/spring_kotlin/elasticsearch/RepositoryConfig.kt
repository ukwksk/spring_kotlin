package co.ukwksk.spring_kotlin.elasticsearch;

import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestClientBuilder
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RestClientConfig {

    @Bean(name = arrayOf("esClient"))
    fun elasticsearchClient(): RestHighLevelClient =
        HttpHost(
            "localhost",
            9200,
            "http"
        ).let {
            RestClient.builder(it)
                .setHttpClientConfigCallback(RestClientBuilder.HttpClientConfigCallback { it })
                .setRequestConfigCallback(RestClientBuilder.RequestConfigCallback { it })
        }.let {
            RestHighLevelClient(it)
        }
}
