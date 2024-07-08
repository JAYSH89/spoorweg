package nl.jaysh.spoorweg.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import nl.jaysh.spoorweg.core.data.RailwayRepository
import nl.jaysh.spoorweg.core.network.services.RailwayService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun providesRailwayService(httpClient: HttpClient): RailwayService {
        return RailwayService(httpClient = httpClient)
    }

    @Provides
    @Singleton
    fun providesRailwayRepository(railwayService: RailwayService): RailwayRepository {
        return RailwayRepository(railwayService = railwayService)
    }
}