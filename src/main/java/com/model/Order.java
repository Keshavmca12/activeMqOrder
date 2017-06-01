package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="order_info")
public class Order implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="order_id")
	private String orderId;
	@Column(name="product_name")
    private String productName;
	@Column(name="quantity")
    private int quantity;
	@Enumerated(EnumType.STRING)
    private OrderStatus status;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderId() {
        return orderId;
    }
 
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public OrderStatus getStatus() {
        return status;
    }
 
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
 
     
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity + ", status="
                + status + "]";
    }
 
     
}

//Transaction ID:  100000858543718