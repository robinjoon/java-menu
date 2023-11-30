package menu.util;

import java.util.function.Supplier;

public final class RetryHelper {
    private RetryHelper() {

    }

    public static <E> E retry(Supplier<E> supplier) {
        E result = null;
        while (result == null) {
            result = useSupplier(supplier);
        }
        return result;
    }

    private static <E> E useSupplier(Supplier<E> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
