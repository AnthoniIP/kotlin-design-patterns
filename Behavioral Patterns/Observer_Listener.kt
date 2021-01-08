// O Observer é um padrão de projeto de software que define uma dependência um-para-muitos 
//entre objetos de modo que quando um objeto muda o estado, todos seus dependentes são 
//notificados e atualizados automaticamente. Permite que objetos interessados 
//sejam avisados da mudança de estado ou outros eventos ocorrendo num outro objeto.

//O padrão Observer é também chamado de Publisher-Subscriber, Event Generator e Dependents.

interface TextChangedListener {
	
	fun onTextChanged(oldText: String, newText: String)
}

class printingTextChangedListener : TextChangedListener {

	private var texto = ""

	override fun onTextChanged(oldText: String, newText: String) {
		text = "Text is changed : $oldText -> $newText"
	}
}
class TextView {

	val listeners = mutableListOf<TextChangedListener>()

	var text: String by Delegates.observable("<empty>") { _,old,new ->

		listeners.forEach { it.onTextChanged(old,new)}
	}
}