package de.appgewaltig.kodeinexample.data.db

import androidx.lifecycle.LiveData
import de.appgewaltig.kodeinexample.data.model.Quote

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}