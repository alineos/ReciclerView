package br.edu.ifsp.dmo.model

class AlgoImportante {
    companion object{
        private var sequence: Int = 1
    }
    var id: Int = 0
        private set

    init{
        id = sequence
        sequence += 1
    }
}