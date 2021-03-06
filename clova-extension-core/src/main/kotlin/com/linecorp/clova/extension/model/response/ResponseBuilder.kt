/*
 * Copyright (c) 2018 LINE Corporation. All rights Reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.linecorp.clova.extension.model.response

import com.linecorp.clova.extension.API_VERSION
import com.linecorp.clova.extension.model.directive.Directive

/**
 * The clova response builder
 *
 * @throws IllegalArgumentException if the outputSpeech is null
 */
class ResponseBuilder {

    //Default values
    var shouldEndSession: Boolean = false
    var sessionAttributes: Map<String, Any> = mapOf()
    var responseLanguage: SupportedLanguage = SupportedLanguage.JA
    var outputSpeech: Speech? = null

    var repromptMessage: String? = null

    var directives: ArrayList<Directive> = arrayListOf()

    //TODO: cards is not supported yet.
    private val cards: ArrayList<String> = arrayListOf()

    fun build(): ClovaExtensionResponse {
        if (outputSpeech == null) {
            throw IllegalArgumentException("outputSpeech couldn't be null")
        }

        val reprompt = repromptMessage?.let {
            SimpleSpeech(
                    values = SpeechInfo(
                            type = SpeechInfoType.PlainText,
                            lang = responseLanguage,
                            value = it
                    )
            )
        }
        return ClovaExtensionResponse(
                version = API_VERSION,
                sessionAttributes = sessionAttributes,
                responseBody = ResponseBody(
                        outputSpeech = outputSpeech!!,
                        directives = directives,
                        cards = cards,
                        shouldEndSession = shouldEndSession,
                        reprompt = reprompt
                )
        )
    }
}
