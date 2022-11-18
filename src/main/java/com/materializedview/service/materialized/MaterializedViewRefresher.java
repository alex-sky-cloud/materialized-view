package com.materializedview.service.materialized;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class MaterializedViewRefresher {

    private final EntityManager entityManager;

    @Transactional
    @Scheduled(fixedRate = 5000L)
    public void refresh(){
        this
                .entityManager
                .createNativeQuery("call refresh_materialized_view();")
                .executeUpdate();
    }
}
