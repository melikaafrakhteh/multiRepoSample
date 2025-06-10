package extensions

import entity.ErrorEntity
import entity.ResultState


fun <D, T> ResultState.Success<D>.toSuccessResult(data: T): ResultState<T> {
    return ResultState.Success(data = data, responseCode = responseCode)
}

fun <D, T> ResultState.Error<D>.toSuccessResult(data: T): ResultState<T> {
    return ResultState.Success(data = data, responseCode = error.responseCode)
}

fun <T> ErrorEntity.Error.toErrorResult(): ResultState<T> {
    return ResultState.Error(error = this)
}
