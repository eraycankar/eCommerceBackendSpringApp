# eCommerceBackendSpringApp
# E Commerce Backend Spring App

## REST Endpoints
The following REST endpoints are available upon deployment:

| HTTP Verb        | URL           | Description  |
| ------------- |-------------|:-----|
| `GET` | `http://localhost:8080/api/customers` | Obtains a list of all existing Customers |
| `GET` | `http://localhost:8080/api/customers/{id}` | Obtains the Customer corresponding to the supplied Customer ID |
| `POST` | `http://localhost:8080/api/customers` | Creates a new Customer based on the payload contained in the request body |
| `PUT` | `http://localhost:8080/api/customers/{id}` | Updated an existing Customer with the data contained in the request body |
||||
| `GET` | `http://localhost:8080/api/order` | Obtains a list of all existing Orders |
| `GET` | `http://localhost:8080/api/customers/{customerId}/order` | Obtains a list of Orders corresponding to the supplied Customer ID|
| `GET` | `http://localhost:8080/api/order/{from}/{to}` | Retriew Orders that is in passed date range|
| `POST` | `http://localhost:8080/api/customers/{customerId}/order` | Creates a new Order based on the Customer ID |
||||
| `GET` | `http://localhost:8080/api/orderDetails` | Obtains a list of all existing OrderDetails |
| `GET` | `http://localhost:8080/api/order/{ordersId}/orderDetails` | Obtains the OrderDetails corresponding to the supplied Orders ID |
| `POST` | `http://localhost:8080/api/order/{ordersId}/orderDetails` | Creates a new OrderDetail based on the Orders ID|
||||
| `GET` | `http://localhost:8080/api/products` | Obtains a list of all existing Products|
| `GET` | `http://localhost:8080/api/products/{id}` | Obtains the Customer corresponding to the supplied Product ID |
| `POST` | `http://localhost:8080/api/products` | Creates a new Product based on the payload contained in the request body |
| `PUT` | `http://localhost:8080/api/products/{id}` | Updated an existing Product with the data contained in the request body |





