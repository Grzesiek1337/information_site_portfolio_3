package com.informations24h.informations24h.repository;

import com.informations24h.informations24h.model.Post;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
@Getter
public class PostArchive {

    private List<Post> posts;

    public PostArchive() {
        this.posts = new ArrayList<>();
        posts.add(new Post("Odebrał żelazko zamiast telefonu","Młody chłopak w Sosonowcu szykował się na bal. Gdy prasował koszulę zadzwonił telefon a zamiast niego przyłożył do ucha żelazko", LocalDate.now()));
        posts.add(new Post("Przepraszam Franiu. Wyprała fretke w pralce.","57 letnia mieszkanka Bydgoszczy gdy zaczęłą prać ubranie i chciała odpocząć od życiowych obowiązków zorientowała się że jej domowa fretka gdzieś zniknęła.Tak, w pralce.", LocalDate.now()));
    }
}
