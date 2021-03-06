[clova-extension-core](../../index.md) / [com.linecorp.clova.extension.model.request](../index.md) / [CustomRequest](./index.md)

# CustomRequest

`sealed class CustomRequest`

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `val type: `[`RequestType`](../-request-type/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [EventRequest](../-event-request/index.md) | `data class EventRequest : `[`CustomRequest`](./index.md)<br>The event request, which is used for audio application |
| [IntentRequest](../-intent-request/index.md) | `data class IntentRequest : `[`CustomRequest`](./index.md) |
| [LaunchRequest](../-launch-request/index.md) | `data class LaunchRequest : `[`CustomRequest`](./index.md) |
| [SessionEndedRequest](../-session-ended-request/index.md) | `data class SessionEndedRequest : `[`CustomRequest`](./index.md) |
