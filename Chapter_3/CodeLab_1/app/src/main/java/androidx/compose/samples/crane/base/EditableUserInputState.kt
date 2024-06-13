package androidx.compose.samples.crane.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue

class EditableUserInputState(private val hint: String, initialText: String) {
    var text by mutableStateOf(initialText)

    val isHint: Boolean
        get() = text == hint || text.isEmpty()

    companion object {
        val Saver: Saver<EditableUserInputState, *> = listSaver(
            save = { listOf(it.hint, it.text) },
            restore = {
                EditableUserInputState(
                    hint = it[0],
                    initialText = it[1]
                )
            }
        )
    }

    fun updateText(newText: String) {
        text = newText
    }
}
