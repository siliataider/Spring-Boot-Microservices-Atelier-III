package com.sp.service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
public class CardGenerator implements ApplicationRunner {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Card c1 = new Card(1,"John", "https://ekladata.com/9-cPSlYvrenNHMVawFmf_gLx8Jw.gif", "blabla","blabla",1,1,1,1,"blabla" );
        Card c2 = new Card(2,"Roberto", "https://ekladata.com/JEVyY9DkwX4vVkakeBfikSyPROA.gif","blabla","blabla",1,1,1,1,"blabla");
        Card c3 = new Card(3,"Anna", "https://ekladata.com/fMJl--_v-3CmisaynTHju1DMeXE.gif", "blabla","blabla",1,1,1,1,"blabla" );
        Card c4 = new Card(4,"Angry Joe", "https://ekladata.com/AmbNNNvv-4YFEMZR8XD8e54WoHc.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c5 = new Card(5,"Ursula", "https://ekladata.com/CXJhi2YLUbNz6__e0Ct6ZP-XOds.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c6 = new Card(6,"Ursula", "https://media.giphy.com/media/Hyl3lQlshKKkg/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c7 = new Card(7,"Ursula", "https://media.giphy.com/media/wZHzd1ZL3oENO/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c8 = new Card(8,"Ursula", "https://media.giphy.com/media/hllwtNe9cnAeA/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c9 = new Card(9,"Ursula", "https://media.giphy.com/media/12TWOd7F94aZLq/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c10 = new Card(10,"Ursula", "https://media.giphy.com/media/KyARpzWBDK5f7eFtPa/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c11 = new Card(11,"Ursula", "https://media.giphy.com/media/chWSgAf2Zw6SUEdZPx/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c12 = new Card(12,"Ursula", "https://media.giphy.com/media/3o72F34NZzBvy8w4a4/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c13 = new Card(13,"Ursula", "https://media.giphy.com/media/O2JeZyEEncFgWCGNWc/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c14 = new Card(14,"Ursula", "https://media.giphy.com/media/gegsYiciYvqmA5CwT7/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c15 = new Card(15,"Ursula", "https://media.giphy.com/media/toYIS95xETUPLmU9WP/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c16 = new Card(16,"Ursula", "https://media.giphy.com/media/SJXzadwbexJEAZ9S1B/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        Card c17 = new Card(9,"Ursula", "https://media.giphy.com/media/CXaDzPow0SJqM/giphy.gif", "blabla","blabla",1,1,1,1,"blabla");
        cardRepository.saveAll(asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17));
    }
}
