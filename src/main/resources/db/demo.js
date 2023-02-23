/*
 Navicat Premium Data Transfer

 Source Server         : localmongodb
 Source Server Type    : MongoDB
 Source Server Version : 30221 (3.2.21)
 Source Host           : localhost:27017
 Source Schema         : demo

 Target Server Type    : MongoDB
 Target Server Version : 30221 (3.2.21)
 File Encoding         : 65001

 Date: 23/02/2023 19:31:49
*/


// ----------------------------
// Collection structure for memberReadHistory
// ----------------------------
db.getCollection("memberReadHistory").drop();
db.createCollection("memberReadHistory");

// ----------------------------
// Documents of memberReadHistory
// ----------------------------
db.getCollection("memberReadHistory").insert([ {
    _id: ObjectId("62ebc03dcebf59033d9c6d2e"),
    memberId: NumberLong("1"),
    memberNickname: "string",
    memberIcon: "string",
    productId: NumberLong("3"),
    productName: "string",
    productPic: "string",
    productSubTitle: "string",
    productPrice: "string",
    createTime: ISODate("2022-08-04T12:49:01.938Z"),
    _class: "com.example.demo.document.MemberReadHistory"
} ]);
