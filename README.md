# Đổi key đi t hết coin r :(((
[![Facebook: FB](https://img.shields.io/badge/Facebook-FB
)](https://www.facebook.com/hiimcorn)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


## Code cơ bản

### 1. Key lấy trong phantom wallet
```java
PublicKey mainPublicKey = new PublicKey("Key người gửi"); //VIETANH12
PublicKey toPublicKey = new PublicKey("Key người nhận"); //NGTRPHUC
``` 
### 2. Secret key của người gửi
```java
String secret_key = "Trong phantom";
```
### 3. Tạo transaction
```java
Transaction transaction = new Transaction(mainPublicKey, toPublicKey, 1000, secret_key);
```
### 4. Ký transaction
```java
transaction.sign(secret_key);
```
### 5. Gửi transaction
```java
transaction.send();
```
### 6. Kiểm tra transaction
```java
transaction.check();
```
### 7. Lấy lịch sử giao dịch
```java
transaction.getHistory();
```
### 8. Lấy số dư
```java
transaction.getBalance();
```
### 9. Lấy thông tin của một transaction
```java
transaction.getTransactionInfo("Transaction ID");
```
### 10. Lấy thông tin của một block
```java
transaction.getBlockInfo("Block ID");
```
### 11. Lấy thông tin của một account
```java
transaction.getAccountInfo("Account ID");
```
### 12. Lấy thông tin của một token
```java
transaction.getTokenInfo("Token ID");
```
### 13. Lấy thông tin của một contract
```java
transaction.getContractInfo("Contract ID");
```

