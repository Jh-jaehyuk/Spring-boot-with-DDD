package com.example.demo.dice.repository;

import com.example.demo.dice.entity.Dice;
import org.springframework.stereotype.Repository;

// Spring Beans <<<
// Spring Core가 IoC Container를 관리하는데
// @Controller, @Service, @Repository 붙은 애들이 결국 Beans
// 결론적으로 @Repository 라는 것을 알려줘서
// 이것이 싱글톤이니까 알아서 RequiredArgsConstructor가 인식하도록 만드세요.

@Repository
public class DiceRepositoryImpl implements DiceRepository {
    final int MIN = 1;
    final int MAX = 6;

    private int createRandomNumber() {
        int randomNumber = (int) (Math.random() * MAX) + MIN;
        return randomNumber;
    }

    @Override
    public Dice rollDice() {
        int randomNumber = createRandomNumber();
        // python 생성자엔 new를 명시하지 않고 그냥 사용합니다.
        // 반면 Java의 경우 new 키워드를 붙여서 사용해야 합니다.
        Dice dice = new Dice(randomNumber);
        return dice;
    }
}
