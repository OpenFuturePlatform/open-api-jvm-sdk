package io.openfuture.api.sender

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.openfuture.api.domain.error.Error
import io.openfuture.api.exception.ClientException
import io.openfuture.api.exception.ServerException
import io.openfuture.api.util.HttpStatusGroup
import io.openfuture.api.util.HttpStatusGroup.*
import org.apache.http.HttpHeaders.AUTHORIZATION
import org.apache.http.HttpHeaders.CONTENT_TYPE
import org.apache.http.client.methods.*
import org.apache.http.entity.ContentType.APPLICATION_JSON
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils.toString

abstract class BaseSender(
        baseRoute: String,
        private val token: String
) {

    private val openRoute = "https://api.openfuture.io$baseRoute"
    private val mapper: ObjectMapper = jacksonObjectMapper()


    protected fun <T> get(route: String, responseClass: TypeReference<T>): T =
            send(HttpGet("$openRoute$route"), responseClass)

    protected fun <T> post(route: String, responseClass: TypeReference<T>, body: Any? = null): T {
        val request = HttpPost("$openRoute$route")
        body?.let {
            request.entity = StringEntity(mapper.writeValueAsString(it))
            request.addHeader(CONTENT_TYPE, APPLICATION_JSON.mimeType)
        }
        return send(request, responseClass)
    }

    protected fun <T> put(route: String, responseClass: TypeReference<T>, body: Any? = null): T {
        val request = HttpPut("$openRoute$route")
        body?.let {
            request.entity = StringEntity(mapper.writeValueAsString(it))
            request.addHeader(CONTENT_TYPE, APPLICATION_JSON.mimeType)
        }
        return send(request, responseClass)
    }

    protected fun <T> patch(route: String, responseClass: TypeReference<T>, body: Any? = null): T {
        val request = HttpPatch("$openRoute$route")
        body?.let {
            request.entity = StringEntity(mapper.writeValueAsString(it))
            request.addHeader(CONTENT_TYPE, APPLICATION_JSON.mimeType)
        }
        return send(request, responseClass)
    }

    protected fun <T> delete(route: String, responseClass: TypeReference<T>): T =
            send(HttpDelete("$openRoute$route"), responseClass)

    private fun <T> send(request: HttpUriRequest, responseClass: TypeReference<T>): T {
        val client = HttpClientBuilder.create().build()
        return client.use {
            request.addHeader(AUTHORIZATION, token)
            val response = it.execute(request)
            when (HttpStatusGroup.valueOf(response.statusLine.statusCode)) {
                SUCCESSFUL -> mapper.readValue(toString(response.entity), responseClass)
                CLIENT_ERROR -> throw ClientException(mapper.readValue<Error>(toString(response.entity)).message)
                INFORMATIONAL, REDIRECTION, SERVER_ERROR ->
                    throw ServerException("There are some troubles on server. Please try later")
            }
        }
    }

}