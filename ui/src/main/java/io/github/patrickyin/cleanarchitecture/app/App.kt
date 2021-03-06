package io.github.patrickyin.cleanarchitecture.app

import android.app.Application
import io.github.patrickyin.cleanarchitecture.app.di.component.AppComponent
import io.github.patrickyin.cleanarchitecture.app.di.component.DaggerAppComponent
import io.github.patrickyin.cleanarchitecture.app.di.module.AppModule
import io.github.patrickyin.cleanarchitecture.app.di.module.IOModule
import io.github.patrickyin.cleanarchitecture.app.di.module.RepositoryModule
import io.github.patrickyin.cleanarchitecture.app.di.module.UseCaseModule

class App : Application() {
  val applicationComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
      .appModule(AppModule(this))
      .iOModule(IOModule())
      .repositoryModule(RepositoryModule())
      .useCaseModule(UseCaseModule())
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    initInjector()
  }

  private fun initInjector() {
    applicationComponent.inject(this)
  }
}
