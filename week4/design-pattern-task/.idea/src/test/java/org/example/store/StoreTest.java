package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.example.store.MyStore;
import org.example.store.Product;
import org.example.store.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StoreTest {

    @Mock
    AccountManager accountManager;
    Product product;
    Customer customer;
    Store myStore;
    final String WITHDRAW_SUCCESSFUL = "success";
    final String PRODUCT_OUT_STOCK = "Product out of stock";


    @BeforeEach
    void setup(){
        product = new Product();
        customer = new Customer();
        myStore = new MyStore(accountManager);
    }

    @Test
    void testPaymentSucceeded() {
        // arrange
        product.setQuantity(10);
        when(accountManager.withdraw(any(Customer.class) , eq(product.getPrice()))).thenReturn(WITHDRAW_SUCCESSFUL);
        // act
        myStore.buy(product , customer);
        // assert
        verify(accountManager).withdraw(any(Customer.class) , eq(product.getPrice()));
        assertThat(product.getQuantity()).isEqualTo(9);
    }

    @Test
    void testPaymentProductOUtOfStock() {
        // arrange
        product.setQuantity(0);
        // act and assert
        assertThatThrownBy(() -> myStore.buy(product, customer))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(PRODUCT_OUT_STOCK);
    }

    @Test
    void testPaymentStatusNotSuccess(){
        // arrange
        product.setQuantity(10);
        // act
        when(accountManager.withdraw(customer , product.getPrice())).thenReturn("insufficient account balance");
        // assert
        assertThatThrownBy(()->{ myStore.buy(product , customer);})
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Payment failure: " + "insufficient account balance");
        assertThat(product.getQuantity()).isEqualTo(10);
    }
}
