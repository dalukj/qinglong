/*******************************************************************************
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2024  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 ******************************************************************************/

package io.github.rosemoe.sora.event

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import io.github.rosemoe.sora.lang.Language
import io.github.rosemoe.sora.widget.CodeEditor

/**
 * Editor [Language] changed
 */
class EditorLanguageChangeEvent(editor: CodeEditor, val newLanguage: Language) : Event(editor)

/**
 * This event is triggered after format result is available and is applied to the editor
 */
class EditorFormatEvent(editor: CodeEditor, val isSuccess: Boolean) : Event(editor)

/**
 * Called when the editor is going to be released. That's when [CodeEditor.release] is
 *  called. You may subscribe this event to release resources when you are holding editor-specific
 *  resources.
 *
 * Note that this event will only be triggered once on a certain editor.
 *
 *  @author Rosemoe
 */
class EditorReleaseEvent(editor: CodeEditor) : Event(editor)

/**
 * Event for ime private command execution. When [android.view.inputmethod.InputConnection.performPrivateCommand]
 *  is called, this event will be triggered.
 * You can subscribe to this event in order to interact with your own inputmethod and thus implement
 * specific features between this editor and your IME app.
 *
 * @see android.view.inputmethod.InputConnection.performPrivateCommand
 * @author Rosemoe
 */
class ImePrivateCommandEvent(editor: CodeEditor, val action: String, val data: Bundle?) :
    Event(editor)

/**
 * This event is triggered when editor is building its [EditorInfo] object for IPC.
 * You can customize the info to add extra information for the ime, due to implement specific
 * features between this editor and your own IME. But note that [EditorInfo.inputType], [EditorInfo.initialSelStart],
 * [EditorInfo.initialSelEnd] and [EditorInfo.initialCapsMode] should not be modified. They are
 * managed by editor self.
 *
 * @author Rosemoe
 */
class BuildEditorInfoEvent(editor: CodeEditor, val editorInfo: EditorInfo) : Event(editor)

class EditorFocusChangeEvent(editor: CodeEditor, val isGainFocus: Boolean) : Event(editor)

class EditorAttachStateChangeEvent(editor: CodeEditor, val isAttachedToWindow: Boolean) :
    Event(editor)