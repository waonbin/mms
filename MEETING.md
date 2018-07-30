# 会议模块接口

## 会议基本信息

- 会议一览页面
  * 代码：MeetingController
  * 链接：/admin/meeting
  * 参数：无
  
- 新增会议页面
    * 代码：MeetingController
    * 链接：/admin/meeting/add
    * 参数：无

- 修改会议页面
    * 代码：MeetingController
    * 链接：/admin/meeting/modify
    * 参数：无
    
- 会议详细信息显示页面
    * 代码：MeetingController
    * 链接：/admin/meeting/details
    * 参数：无
   
- 获取会议一览页面数据（分页）
    * 代码：MeetingResource
    * 链接：/admin/meeting/page/{page}
    * 参数：见下表
   
    参数  | 名称| 类型 | 说明
    :---:|:---:|:---:|:---
    page | 页码 | int | 页码，从0开始

- 会议数据保存
    * 代码：MeetingResource
    * 链接：/admin/meeting/save
    * 参数：见下表
   
    参数  | 名称| 类型 | 说明
    :---:|:---:|:---:|:---
    id | 会议id | Long | 新增时可以为空，修改时不能为空
    name | 会议名称 | String | 长度：64
    startDate | 举办开始时间 | Instant | 格式：yyyy-MM-dd
    endDate | 举办结束时间 | Instant | 格式：yyyy-MM-dd
    ~~content~~ | ~~会议内容~~ | ~~String~~ | ~~大文本~~
    ~~description~~ | ~~会议简介~~ | ~~String~~ | ~~大文本~~
    ~~meetingType~~ | ~~会议类型~~ | ~~Short~~ | ~~字典~~
    ~~peopleLimit~~ | ~~报名人数限制~~ | ~~Integer~~ |
    sponsor | 主办单位 | String | 
    organizer | 承办单位 | String |
    address | 会议地址 | String
    longitude | 经度（地址坐标） | Double |
    latitude | 纬度（地址坐标） | Double |
    duesType | 会议费用类型 | Short | 字典：免费，收费
    chargeInSystem | 是否在系统中收费 | Boolean | 
    checkinDate | 报到日期 | Date
 
 - 删除会议
     * 代码：MeetingResource
     * 链接：/admin/meeting/delete
     * 参数：见下表
    
     参数  | 名称| 类型 | 说明
     :---:|:---:|:---:|:---
     id | 会议id | Long | 

## 会务信息