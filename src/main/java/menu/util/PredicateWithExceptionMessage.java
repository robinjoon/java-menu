package menu.util;

import java.util.function.Predicate;

/**
 * 조건을 만족하지 않을 경우 정해진 예외 메세지의 예외를 투척할 수 있도록 Predicate 를 감싼 레코드
 *
 * @param predicate    조건을 만족할 경우 test 메서드가 true를 반환하도록 하는 Predicate
 * @param errorMessage 예외 발생시 사용할 예외 메세지
 * @param <T>
 */
public record PredicateWithExceptionMessage<T>(Predicate<T> predicate, String errorMessage) {
}
