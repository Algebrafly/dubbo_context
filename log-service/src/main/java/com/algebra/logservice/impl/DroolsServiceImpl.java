package com.algebra.logservice.impl;

import com.algebra.logservice.interfaces.IDroolsService;
import com.algebra.logservice.domain.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @author al
 * @date 2019/8/7 9:09
 * @description
 */
@Service
public class DroolsServiceImpl implements IDroolsService {

    private static KieSession KIE_SESSION;

    static {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KIE_SESSION = kContainer.newKieSession("ksession-baseprice");
    }

    @Override
    public String fireRule() {
        // go !
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        KIE_SESSION.insert(message);
        int i = KIE_SESSION.fireAllRules();
        System.out.println("规则执行条数"+i);
        KIE_SESSION.dispose();
        return message.getMessage();
    }

}
