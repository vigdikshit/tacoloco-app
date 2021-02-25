**TacoLoco order calculation API**

I used spring boot to create the rest API.

***Features***
1. API for adding items, removing items and get items in the menu
2. API to calculate total order amount of the order placed

**Classes**
1. Classes under model package: com.tacoLoco.app.model
Four classes - Items.java, OrderList.java, OrderQuantity.java, Messages.java

	i) Items.java - This class contains fields items like items, price and a map to store items with their respective price. It also contains getter and setter methods along with methods to add data, remove data to the map.
	ii) OrderQuantity.java - This class contains fields like item and quantity along with getter and setter. This class is used to map the items and quantity which we get as input into our order calculation api.
	iii) OrderList.java - This class contains a list of OrderQuantity type. In our order calculation api, we will basically get a list of OrderQuantity type.
	iv) Messages.java - This class contains some constants to display messages.

2. Classes under controller package: com.tacoLoco.app.controller
Two classes - ItemController.java, OrderController.java

	i) ItemController.java - This class contains rest controllers like /addItem, /getItems, /removeItem.
	ii) OrderController.java - This class contains rest controller /orderTotal to calculate total order amount.

3. Classes under service package: com.tacoLoco.app.service
Two classes - ItemService.java, OrderService.java

	i) ItemService.java - This class contains respective methods related to ItemController APIs. This class contains all the business logic for the APIs
	ii) OrderService.java - This class contains respective methods related to OrderController API. This class contains all the business logic for the orderTotal API.

4. Main class under package: com.tacoLoco.app

	i) TacoLocoApplication.java - Contains the main method from where the application will start.

**Steps to run the app and how to use APIs**

1. To run the app - Import the project and Go to class "TacoLocoApplication.java" and run it as "Java Application"

2. To add an item and their price:

 use Post method with url - localhost:5000/item/addItem
 In body give as below for example:
 {
	"item":"chicken",
	"price": 3.0
 }
 
 Note: You can only add one item at one time.
 
3. To get all items present:
	use Get method with url - localhost:5000/item/getItems

4. To remove an item:
	use delete method with url: localhost:5000/item/removeItem?item={itemName}
	Example: localhost:5000/item/removeItem?item=chicken

5. To calculate the order total:
	use Post method to give input: localhost:5000/order/orderTotal
	In body, give as below for example:
	{
	"orders" : [
			{"item": "veggie",
			 "quantity": 2
			},
			{"item": "chicken",
			 "quantity": 1
			},
			{"item": "chorizo",
			 "quantity": 3
			}
		]
	}
	I have assumed that input will come in the form of an object containing items ordered along with their quantities.



	



