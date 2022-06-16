package br.com.crudapplication.retrofit.config;

import br.com.crudapplication.proxy.UserProxy;
import br.com.crudapplication.proxy.LoginProxy;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TextPlainRetrofitConfig extends AbstractRetrofitConfig {

    public TextPlainRetrofitConfig() {
        super("https://example-ecommerce.herokuapp.com", ScalarsConverterFactory.create());
    }

    public LoginProxy getLoginProxy() {
        return super.retrofit.create(LoginProxy.class);
    }

    public UserProxy getUserProxy() {
        return super.retrofit.create(UserProxy.class);
    }
}
