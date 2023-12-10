package com.zguiz.musicplayer.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.zguiz.musicplayer.bean.Shopping;
import org.apache.http.HttpHost;
import org.apache.lucene.queryparser.xml.builders.TermQueryBuilder;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ElasticClient {
    public ElasticsearchClient getClient(){
        RestClient client = RestClient.builder(new HttpHost("172.31.253.118",9200)).build();
        ElasticsearchTransport transport = new RestClientTransport(client,new JacksonJsonpMapper());
        ElasticsearchClient elasticClient = new ElasticsearchClient(transport);
        return elasticClient;
    }

    public void addData(ElasticsearchClient client) throws IOException {
        Shopping shopping1 = new Shopping();
        shopping1.setCategory("小米");
        shopping1.setImages("http://fjit4eisje.jpg");
        shopping1.setPrice("58486.99");
        shopping1.setTitle("小米Mix100");
        IndexRequest<Object> indexRequest = new IndexRequest.Builder<>().index("shopping").document(shopping1).build();
        client.index(indexRequest);
    }

    /**
     * 查询全部数据
     * @param client
     * @return
     * @throws IOException
     */
    public List<Shopping> searchAll(ElasticsearchClient client) throws IOException {
        MatchAllQuery build = QueryBuilders.matchAll().build();
        SearchRequest searchRequest = new SearchRequest.Builder().index("shopping").query(build._toQuery()).build();
        return getShoppings(client, searchRequest);
    }

    /**
     * 按条件查询
     * @param client
     * @param index
     * @param category
     * @return
     * @throws IOException
     */
    public List<Shopping> searchByCategory(ElasticsearchClient client,String index,String category) throws IOException {
        TermQuery query = QueryBuilders.term().field("category.keyword").value(category).build();
        SearchRequest searchRequest = new SearchRequest.Builder().index(index).query(query._toQuery()).build();
        return getShoppings(client, searchRequest);
    }

    private List<Shopping> getShoppings(ElasticsearchClient client, SearchRequest searchRequest) throws IOException {
        SearchResponse<Shopping> search = client.search(searchRequest,Shopping.class);
        List<Shopping> shoppings = new ArrayList<>();
        for(Hit<Shopping> item : search.hits().hits()){
            Shopping shopping = item.source();
            System.out.println(shopping.getCategory()+"\t" +shopping.getPrice());
            shoppings.add(shopping);
        }
        return shoppings;
    }

    public void updateRow(ElasticsearchClient client,Shopping shopping){

    }
}

