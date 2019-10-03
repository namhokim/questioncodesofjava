package com.example.springboot.sandbox.naver.hhs9102;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LocalDateTimeNullCheck {
    public static void main(String[] args) {
        Long idOfJoker2019 = 167613L;
        MovieShowtime showtime = getMovieShowtime(idOfJoker2019);
        LocalDateTime pos = LocalDateTime.now();
        if (showtime.isBefore(pos)) {
            System.out.println("You can buy the ticket");
        } else {
            System.out.println("It is wrong.");
        }
    }

    private static MovieShowtime getMovieShowtime(Long movieId) {
        // 보통은 리포지토리나 외부 API 가 되겠지만 생략
        // ...
        LocalDateTime start = LocalDateTime.of(2019, 1, 1, 12, 0, 0);
        LocalDateTime end = LocalDateTime.of(2015, 1, 1, 12, 0, 0);
        return MovieShowtime.of(movieId, start, end);
    }
}

/**
 * 영화 상영시간
 */
@Getter
class MovieShowtime {
    private Long movieId;
    private LocalDateTime start;
    private LocalDateTime end;

    private MovieShowtime(Long movieId, LocalDateTime start, LocalDateTime end) {
        this.movieId = movieId;
        this.start = start;
        this.end = end;
    }

    public static MovieShowtime of(Long movieId, LocalDateTime start, LocalDateTime end) {
        return new MovieShowtime(movieId, start, end);
    }

    public boolean isBefore(@NotNull LocalDateTime pointOnSale) {
        return pointOnSale.isBefore(start);
    }
}