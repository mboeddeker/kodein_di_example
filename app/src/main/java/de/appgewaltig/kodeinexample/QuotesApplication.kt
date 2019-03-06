package de.appgewaltig.kodeinexample

import android.app.Application
import de.appgewaltig.kodeinexample.data.db.Database
import de.appgewaltig.kodeinexample.data.db.DatabaseFakeImpl
import de.appgewaltig.kodeinexample.data.db.QuoteDao
import de.appgewaltig.kodeinexample.data.repository.QuoteRepository
import de.appgewaltig.kodeinexample.data.repository.QuoteRepositoryImpl
import de.appgewaltig.kodeinexample.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        // we bind our database with a singleton. This means, every Time
        // Kodein injects our Database, it uses this singleton instance
        bind<Database>() with singleton { DatabaseFakeImpl() }

        // here we don't need to initate a new QuoteDao, because we already made this
        // inside our Database. You can get it with this instance and call it
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }

        // next powerful thing with Kodein. The QuoteRepositoryImpl needs an quoteDao.
        // above we have our instance of it... only call instance and the magic happens
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }

        // here we use the provider to get new instances on every call, the opposite of singletons
        bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) }

        // to shorten this we can write this:
        // bind() from provider { QuotesViewModelFactory(instance()) }
        // this sets the type automaticlly
    }
}