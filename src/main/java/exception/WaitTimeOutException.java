package exception;

import lombok.AllArgsConstructor;

/**
 * @author ljj
 * @version sprint 8
 * @className WaitTimeOutException
 * @description
 * @date 2020-09-14 19:26:15
 */
public class WaitTimeOutException extends RuntimeException {
    public WaitTimeOutException(String message) {
        super(message);
    }
}
