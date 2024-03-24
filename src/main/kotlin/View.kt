class View(private val archive: Archive = Archive("")) : Navigation() {

    private val archiveList : MutableList<Archive> = mutableListOf()

    fun start() {
        while (true) {
            viewArchive()
        }
    }

    private fun viewArchive() {
        while (true) {
            println("Вы находитесь в реестре архивов. Введите цифру для следующего действия:")
            println("0. Создать архив.")
            archiveList.forEachIndexed { index, archive -> println("${index + 1}. Открыть архив '${archive.name}'") }
            println("${archiveList.size + 1}. Выход.")
            println("\nВведите цифру:")
            when (val input = scanner.nextLine().trim()) {
                "0" -> addArchive()
                "${archiveList.size + 1}" -> exit()
                else -> {
                    val index = input.toIntOrNull()?.minus(1)
                    if (index != null && index in archiveList.indices){
                        View(archiveList[index]).viewNote()
                    } else {
                        println("Пожалуйста, введите цифру из списка.")
                    }
                }
            }
        }
    }

    private fun viewNote() {
        while (true) {
            println("Вы находитесь в реестре заметок архива '${archive.name}'. Введите цифру для следующего действия:")
            println("0. Создать заметку.")
            archive.noteList.forEachIndexed { index, note -> println("${index + 1}. Открыть заметку '${note.name}'") }
            println("${archive.noteList.size + 1}. Вернуться в реестр архивов.")
            println("\nВведите цифру: ")
            when (val input = scanner.nextLine().trim()) {
                "0" -> addNote(archive)
                "${archive.noteList.size + 1}" -> return
                else -> {
                    val index = input.toIntOrNull()?.minus(1)
                    if (index != null && index in archive.noteList.indices){
                        choiceNote(archive.noteList[index])
                    } else {
                        println("Пожалуйста, введите цифру из списка.")
                    }
                }
            }
        }
    }

    private fun addArchive(){
        val archiveName = input("Введите название архива: ")
        val archive = Archive(archiveName)
        archiveList.add(archive)
        println("Создан архив ${archiveName}.")
    }

    private fun addNote(archive: Archive) {
        val noteName = input("Введите название заметки: ")
        val noteText = input("Введите текст заметки: ")
        val newNote = Note(noteName, noteText)
        archive.noteList.add(newNote)
    }

    private fun choiceNote(note: Note) {
        while (true) {
            println("\nСодержание заметки ${note.name}:\n" + note.text)
            inputSome()
            break
        }
    }

}