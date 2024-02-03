package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 빈 생명주기 콜백 확인 방법
 * <p>
 * 1 - 인터페이스 사용
 * InitializingBean -> 초기화 지원
 * DisposableBean -> 소멸 지원
 * <p>
 * 1. 위 인터페이스들은 스프링 전용 인터페이스라서, 해당 코드가 스프링 전용 인터페이스에 의존하게 된다.
 * 2. 초기화, 소멸 메소드의 이름을 변경할 수 없다.
 * 3. 내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.
 * -> 인터페이스를 통한 초기화 방법은 스프링 초창기에 나온 방법이다.
 * <p>
 * 2 - 빈 등록 초기화, 소멸
 * <p>
 * Bean(initMethod = "", destroyMethod = "")
 * 1. 메서드 이름을 자유롭게 줄 수있다.
 * 2. 스프링 빈이 스프링 코드에 의존하지 않는다.
 * 3. 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.
 * <p>
 * 3 - 애노테이션 PostConstruct, PreDestroy
 * <p>
 * 1. 스프링에선 이 방법을 사용하면 된다. (공식 권장 방법)
 * 단점 - 외부 라이브러리에선 사용을 못하니, 외부라이브러리를 초기화, 종료 해야하면 Bean 의 initMethod, destroyMethod 를 사용.
 */
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close" + url);
    }


    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
