package br.com.crudapplication.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.crudapplication.R;
import br.com.crudapplication.model.Product;

public class ProductAdapter extends BaseAdapter {

    private final List<Product> products;
    private final Activity activity;

    public ProductAdapter(List<Product> products, Activity activity) {
        this.products = products;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.product_list_layout, parent, false);
        Product product = this.products.get(position);

        TextView productName = view.findViewById(R.id.product_list_layout_product_name);
        TextView productPrice = view.findViewById(R.id.product_list_layout_product_price);
        TextView productAmount = view.findViewById(R.id.product_list_layout_product_amount);
        TextView productFactory = view.findViewById(R.id.product_list_layout_product_factory);

        productName.setText("Name: " + product.getName());
        productPrice.setText("Price: R$ " + product.getPrice());
        productAmount.setText("Amount: " + product.getAmount());
        productFactory.setText("Factory: " + product.getFactory().getName());

        return view;
    }
}
