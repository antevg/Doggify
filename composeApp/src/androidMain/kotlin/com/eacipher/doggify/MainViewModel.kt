package com.eacipher.doggify


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eacipher.doggify.model.Breed
import com.eacipher.doggify.model.FetchBreedsUseCase
import com.eacipher.doggify.model.GetBreedsUseCase
import com.eacipher.doggify.model.ToggleFavouriteStateUseCase
import com.eacipher.doggify.repository.BreedsRepository
import kotlinx.coroutines.flow.*


class MainViewModel(
    breedsRepository: BreedsRepository,
    private val getBreeds: GetBreedsUseCase,
    private val fetchBreeds: FetchBreedsUseCase,
    private val onToggleFavouriteState: ToggleFavouriteStateUseCase
): ViewModel() {

    private val _state = MutableStateFlow(State.LOADING)
    val state: StateFlow<State> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    private val _events = MutableSharedFlow<Event>()
    val events: SharedFlow<Event> = _events

    private val _shouldFilterFavourites = MutableStateFlow(false)
    val shouldFilterFavourites: StateFlow<Boolean> = _shouldFilterFavourites


    val breeds =
        breedsRepository.breeds.combine(shouldFilterFavourites) { breeds, shouldFilterFavourites ->
            if (shouldFilterFavourites) {
                breeds.filter { it.isFavourite }
            } else {
                breeds
            }.also {
                _state.value = if (it.isEmpty()) State.EMPTY else State.NORMAL
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    enum class State {
        LOADING,
        NORMAL,
        ERROR,
        EMPTY
    }

    enum class Event {
        Error
    }


}