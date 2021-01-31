# Customer Group Shopping Microservice

## Description
The service allows registered customers to make group purchases in order to receive discounts on products.<br>
The service integrates with User Management Service and Product Management Service.<br>
This Microservice built in Java using SpringBoot framework, with Gradle build tools.<br>
The database was configured using MongoDB to store the data.

## Usage
Product Microservice API:
<table>
    <th>Method</th>
    <th>Route</th>
    <th>Usage</th>
		<tr>
			<td><b><b>GET</b></b></td>
			<td> /groups?sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}</td>
			<td>An action that returns in a sorted manner all the existing purchasing groups in the service.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/groups?filterType=byInitiator&filterValue={email}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}</td>
			<td>An action that returns all the purchasing groups of a specific user existing in the service.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/groups?filterType=byMinNumOfMemebers&filterValue={minNum}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}</td>
			<td>An action that returns all the purchasing groups in which the number of participants is at least a minimum number specified in the URL.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/groups?filterType=byMaxNumOfMemebers&filterValue={maxNum}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}</td>
			<td>An action that returns all the purchasing groups whose number of participants is at most a maximum number specified in the URL.</td>
		</tr>
		<tr>
			<td><b>GET</b></td>
			<td>/groups?filterType=byDiscount&filterValue={minDiscount}&sortBy={sortAttr}&sortOrder={order}&page={page)&size={size}</td>
			<td>An action that returns in a sorted manner all purchasing groups that the discount they offer is at least a minimum number specified in the URL.</td>
		</tr>
  		<tr>
			<td><b>GET</b></td>
			<td>/groups?filterType=byCreationTime&filterValue={timeEnum}&sortBy={sortArrt}&sortOrder={order}&page={page)&size={size}</td>
			<td>>An action that returns in a sorted manner all the purchase groups created at a certain time.<br>
				timeEnum can have one of the following values:<br>
				lastDay - will return groups published in the last 24 hours.<br>
				lastWeek - will return groups published in the last week.<br>
				lastMonth - will return groups published in the last 30 days.</td>
		</tr>
    <tr>
			<td><b>POST</b></td>
			<td>/groups</td>
			<td>An action that receives purchase group information and stores it in the system.<br>
      *The user must be registered to the User Management Service. And the product must be registered to the Product Management Service.</td>
		</tr>   
    <tr>
			<td><b>PUT</b></td>
			<td>/groups/{groupId}</td>
			<td>An action that updates group information that is already stored in the system and is identified by the group number.
          This can update the list of emails of those who have joined the group (members) and the number of products that the group can purchase (prodQuantity)
          The other characteristics of a group will not change due to this action. If there is no such set, the method returns an appropriate error code.</td>
		</tr>
    <tr>
			<td><b>DELETE</b></td>
			<td>/groups</td>
			<td>An action that deletes all purchase groups that the service manages and returns nothing.</td>
		</tr>

</table>

## JSON for Customer Group Shopping example:
```json
“groupId”: "uuid",
“initiator”: {
    "email":"user1@gmail.com"
},
“numOfMembers”: 50,
“members”: [ {"email": "member1@gmail.com”}, 
		{"email": "member2@gmail.com”}, 
		{"email": "member3@gmail.com”}, 
],
“product”:{
    "id":"4684"
},
“prodQuantity”: 60,
“discount”: 0.05,
“dateOpened”: “2021-01-14T04:12:39.053+0000”,
“validity”: 30,
“extras”: {
“conditions”: ”The group must have at least 25 members”,
“notes”: ”The product will be provided 15 days from purchase date”
  }
}

```
