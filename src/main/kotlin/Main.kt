import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.example.models.Message
import io.ktor.util.*
import kotlinx.coroutines.runBlocking

@OptIn(InternalAPI::class)
fun main() = runBlocking {
    val client = HttpClient(CIO)

    val message = Message("Hola")
    val response: HttpResponse = client.post("http://localhost:8080/message") {
        contentType(ContentType.Application.Json)
        body = Json.encodeToString(message)
    }
    println("Message sent: ${response.status}")

    val receivedMessage: String = client.get("http://localhost:8080/message").toString()
    println("Message received: $receivedMessage")

    client.close()
}