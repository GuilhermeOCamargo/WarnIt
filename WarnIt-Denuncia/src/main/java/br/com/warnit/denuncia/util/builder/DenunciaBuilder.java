package br.com.warnit.denuncia.util.builder;

import br.com.warnit.denuncia.model.domain.Denuncia;

import java.util.Calendar;

public class DenunciaBuilder {
    private Denuncia denuncia;

    private DenunciaBuilder(){}

    public static DenunciaBuilder create(){
        DenunciaBuilder builder = new DenunciaBuilder();
        builder.denuncia = new Denuncia();
        builder.denuncia.setDataHora(Calendar.getInstance());
        builder.denuncia.setDetalhes("Detalhes da denuncia devem ser inseridos neste campo!");
        builder.denuncia.setFilePath("fakepath/file{timestamp}.extension");
        return builder;
    }

    public Denuncia get(){
        return denuncia;
    }

}
