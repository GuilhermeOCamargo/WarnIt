package br.com.warnit.util.builder;

import br.com.warnit.model.domain.CategoriaDenuncia;

public class CategoriaDenunciaBuilder {
    private CategoriaDenuncia categoriaDenuncia;

    private CategoriaDenunciaBuilder(){}

    public static CategoriaDenunciaBuilder create(){
        CategoriaDenunciaBuilder builder = new CategoriaDenunciaBuilder();
        builder.categoriaDenuncia = new CategoriaDenuncia();
        builder.categoriaDenuncia.setNome("Assédio");
        return builder;
    }

    public CategoriaDenuncia get(){
        return categoriaDenuncia;
    }
}
