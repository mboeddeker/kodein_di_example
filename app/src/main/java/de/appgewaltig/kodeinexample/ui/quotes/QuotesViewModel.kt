package de.appgewaltig.kodeinexample.ui.quotes

import androidx.lifecycle.ViewModel
import de.appgewaltig.kodeinexample.data.model.Quote
import de.appgewaltig.kodeinexample.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
    fun getQuotes() = quoteRepository.getQuotes()
}