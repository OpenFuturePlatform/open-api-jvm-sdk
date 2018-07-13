package io.openfuture.sdk.config

import org.apache.http.HttpEntity
import org.apache.http.StatusLine
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(HttpClientBuilder::class, EntityUtils::class)
abstract class SenderTests {

    @Mock private lateinit var builder: HttpClientBuilder
    @Mock private lateinit var client: CloseableHttpClient
    @Mock private lateinit var response: CloseableHttpResponse
    @Mock protected lateinit var statusLine: StatusLine
    @Mock protected lateinit var entity: HttpEntity

    protected val token = "ok_token"


    @Before
    fun setUp() {
        mockStatic(HttpClientBuilder::class.java)
        mockStatic(EntityUtils::class.java)
        `when`(HttpClientBuilder.create()).thenReturn(builder)
        given(builder.build()).willReturn(client)
        given(client.execute(any(HttpUriRequest::class.java))).willReturn(response)
        given(response.statusLine).willReturn(statusLine)
        given(response.entity).willReturn(entity)
    }

}