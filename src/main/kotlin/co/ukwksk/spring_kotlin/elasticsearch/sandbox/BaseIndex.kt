package co.ukwksk.spring_kotlin.elasticsearch.sandbox

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository

@NoRepositoryBean
interface BaseIndex<SCHEMA> : PagingAndSortingRepository<SCHEMA, String>
