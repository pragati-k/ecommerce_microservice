## Table of Contents
1. [General Info](#general-info)
2. [List of Microservices](#list-of-microservices)
3. [Url definations](#url-definations)
4. [Docker Images](#docker-images)
### General Info
***
A backend for a web application of an ecommerce company using Microservices Architecture. 
###### Cross-cutting concerns taken care of
    - logging
    - exception handling
    - circuit breaker using hystrix

## List of Microservices
***
* **Product service** - provides the product and details.
* **Product Details service** - provides the details of the products.
* **Cart Service** - provides the functionality to add products to cart.
* **Admin Service** - can add/remove new products to inventory and details of the product.
* **Eureka Service** - Discovery service.
* **API gateway service** - for routing.

### Url definations
1. product service
    * http://localhost:9001/product/allProducts - to diplay all products.
    * http://localhost:9001/product/{productId} - get single product.
    * http://localhost:9001/product/addProducts - post product.
    * http://localhost:9001/product/deleteProduct/{productId} - delete product.
2. Product Details service
    * http://localhost:9002/details/allDetails - to diplay all details.
    * http://localhost:9002/details/product/{productId} - get details of single product.
    * http://localhost:9002/details/addDetails - post details.
    * http://localhost:9002/details/deleteDetails/{productId} - delete details.
3. Cart Service
    * http://localhost:9005/cart/allCart - to diplay cart.
    * http://localhost:9005/cart/addCart/{productId} - add a product.
    * http://localhost:9005/cart/deleteCart/{productId} - remove a product from cart.
    * http://localhost:9005/cart/removeCart - remove all products.
4. Admin Service
    * http://localhost:9000/admin/addDetails - to add details.
    * http://localhost:9000/admin/deleteDetails/{detailsId} - delete details.
    * http://localhost:9000/admin/addProducts - add a product.
    * http://localhost:9000/admin/deleteProduct/{productId} - delete a product.
    * http://localhost:9000/admin/allAdmins - get all admins.
    * http://localhost:9000/admin/{adminId} - single admin.
    * http://localhost:9000/admin/isAdmin - check if entered user is admin or not.
     * http://localhost:9000/admin/addAdmin - add a admin.
    * http://localhost:9000/admin/deleteAdmin/{adminId} - remove admin.
5. Eureka servie
    * http://localhost:8761 - Eureka dashboard.
6. Api gateway service
    * http://localhost:8999/... - a single point to access all the services.

## Docker Images
***
* **Product service** - https://hub.docker.com/repository/docker/pragatikundu/product-service
* **Product Details service** - https://hub.docker.com/repository/docker/pragatikundu/productdetails-service
* **Cart Service** - https://hub.docker.com/repository/docker/pragatikundu/productdetails-service
* **Admin Service** - https://hub.docker.com/repository/docker/pragatikundu/productdetails-service
* **Eureka Service** - https://hub.docker.com/repository/docker/pragatikundu/eureka-service
* **API gateway service** - https://hub.docker.com/repository/docker/pragatikundu/apigateway-service
