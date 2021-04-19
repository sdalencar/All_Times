package com.sdainfo.alltimes.ui.act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.sdainfo.alltimes.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sobre2);
        String descricao = "A empresa de Marketing Digital Alaska deixou de lado jargões empresariais na sua página de about: pelo contrário, a linguagem utilizada é simples e direta.\n" +
                "\n" +  "Na página, é possível saber rapidamente em quais áreas a empresa atua e os serviços que oferece. Isso é importante, pois é justamente o que um usuário espera quando visita essa página – se ele não encontra as informações que busca, é provável que saia do site sem saber se precisa do seu produto ou serviço.\n";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale Conosco")
                .addEmail("email.com.br")
                .addWebsite("www.sdaalltimes.com.br")
                .addGitHub("githuballtimes")
                .addGroup("nossas redes sociais")
                .addFacebook("sdaalltimes.facebook")
                .addTwitter("goggle")
                .addPlayStore("goggle")
                .addInstagram("sda all times", "titulo")
                .create();

        setContentView(sobre);


    }
}