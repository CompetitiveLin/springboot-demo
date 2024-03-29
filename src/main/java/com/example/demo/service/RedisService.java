package com.example.demo.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: RedisService <br/>
 * Description: redis操作接口 <br/>
 */
public interface RedisService {
    /**
     * 保存属性
     *
     * @param key   key值
     * @param value value值
     * @param time  时间戳
     */
    void set(String key, Object value, long time);

    /**
     * 保存属性
     *
     * @param key   key值
     * @param value value值
     */
    void set(String key, Object value);

    /**
     * 获取属性
     *
     * @param key key值
     * @return 返回对象
     */
    Object get(String key);

    /**
     * 删除属性
     *
     * @param key key值
     * @return 返回成功
     */
    Boolean delete(String key);

    /**
     * 批量删除属性
     *
     * @param keys key值集合
     * @return 返回删除数量
     */
    Long delete(List<String> keys);

    /**
     * 设置过期时间
     *
     * @param key  key值
     * @param time 时间戳
     * @return 返回成功
     */
    Boolean expire(String key, long time);

    /**
     * 获取过期时间
     *
     * @param key key值
     * @return 返回时间戳
     */
    Long getExpire(String key);

    /**
     * 判断key是否存在
     *
     * @param key key值
     * @return 返回
     */
    Boolean hasKey(String key);

    /**
     * 按delta递增
     *
     * @param key   key值
     * @param delta delta值
     * @return 返回递增后结果
     */
    Long incr(String key, long delta);

    /**
     * 按delta递减
     *
     * @param key   key值
     * @param delta delta值
     * @return 返回递减后结果
     */
    Long decr(String key, long delta);


    // ============================= Hash =============================

    /**
     * 获取Hash结构中的属性
     *
     * @param key     外部key值
     * @param hashKey 内部key值
     * @return 返回内部key的value
     */
    Object hGet(String key, String hashKey);

    /**
     * 向Hash结构中放入一个属性
     *
     * @param key     外部key
     * @param hashKey 内部key
     * @param value   内部key的value
     * @param time    过期时间
     * @return 返回是否成功
     */
    Boolean hSet(String key, String hashKey, Object value, long time);

    /**
     * 向Hash结构中放入一个属性
     *
     * @param key     外部key
     * @param hashKey 内部key
     * @param value   内部key的value
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * 直接获取整个Hash结构
     *
     * @param key 外部key值
     * @return 返回hashMap
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * 直接设置整个Hash结构
     *
     * @param key  外部key
     * @param map  hashMap值
     * @param time 过期时间
     * @return 返回是否成功
     */
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    /**
     * 直接设置整个Hash结构
     *
     * @param key 外部key
     * @param map hashMap值
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * 删除Hash结构中的属性
     *
     * @param key     外部key值
     * @param hashKey 内部key值
     */
    Long hDel(String key, Object... hashKey);

    /**
     * 判断Hash结构中是否有该属性
     *
     * @param key     外部key
     * @param hashKey 内部key
     * @return 返回是否存在
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Hash结构中属性递增
     *
     * @param key     外部key
     * @param hashKey 内部key
     * @param delta   递增条件
     * @return 返回递增后的数据
     */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * Hash结构中属性递减
     *
     * @param key     外部key
     * @param hashKey 内部key
     * @param delta   递增条件
     * @return 返回递减后的数据
     */
    Long hDecr(String key, String hashKey, Long delta);


    // ============================= Set =============================

    /**
     * 获取Set结构
     *
     * @param key key
     * @return 返回set集合
     */
    Set<Object> sMembers(String key);

    /**
     * 向Set结构中添加属性
     *
     * @param key    key
     * @param values value集
     * @return 返回增加数量
     */
    Long sAdd(String key, Object... values);

    /**
     * 向Set结构中添加属性
     *
     * @param key    key
     * @param time   过期时间
     * @param values 值集合
     * @return 返回添加的数量
     */
    Long sAdd(String key, long time, Object... values);

    /**
     * 是否为Set中的属性
     *
     * @param key   key
     * @param value value
     * @return 返回是否存在
     */
    Boolean sIsMember(String key, Object value);

    /**
     * 获取Set结构的长度
     *
     * @param key key
     * @return 返回长度
     */
    Long sSize(String key);

    /**
     * 删除Set结构中的属性
     *
     * @param key    key
     * @param values value集合
     * @return 删除掉的数据量
     */
    Long sRemove(String key, Object... values);

    // ============================= Zset =============================


    /**
     * 增加有序集合
     *
     * @param key   key
     * @param value value
     * @param score 权重
     * @return  返回是否成功
     */
    Boolean zAddIfAbsent(String key, Object value, double score);

    /**
     * 获取zset集合数量
     *
     * @param key   key
     * @return  返回集合数量
     */
    Long zCount(String key);


    /**
     * 获取zset指定范围内的集合
     *
     * @param key   key
     * @param start 初始下标
     * @param end   结束下标
     * @return  返回指定范围内的集合
     */
    Set<Object> zRange(String key, long start, long end);


    /**
     * 获取zset指定范围内的集合和分数
     * @param key   key
     * @param start 初始下标
     * @param end   结束下标
     * @return  返回指定范围内的集合和分数
     */
    Set<ZSetOperations.TypedTuple<Object>> zRangeWithScores(String key, long start, long end);

    /**
     * 根据key和value移除指定元素
     *
     * @param key   key
     * @param value value集合
     * @return  返回移除元素的数量
     */
    Long zRemove(String key, Object... value);


    /**
     * 获取对应key和value的score
     *
     * @param key   key
     * @param value value
     * @return  返回对应的权重
     */
    Double zScore(String key, Object value);


    /**
     * 指定元素增加指定值
     *
     * @param key   key
     * @param obj   membership
     * @param score 权重
     * @return  返回增加权重后的权重值
     */
    Double zAddScore(String key, Object obj, double score);


    /**
     * 获取排名
     *
     * @param key   key
     * @param obj   membership
     * @return  返回对应的排名
     */
    Long zRank(String key, Object obj);




    // ============================= List =============================

    /**
     * 获取List结构中的属性
     *
     * @param key   key
     * @param start 开始
     * @param end   结束
     * @return 返回查询的集合
     */
    List<Object> lRange(String key, long start, long end);

    /**
     * 获取List结构的长度
     *
     * @param key key
     * @return 长度
     */
    Long lSize(String key);

    /**
     * 根据索引获取List中的属性
     *
     * @param key   key
     * @param index 索引
     * @return 对象
     */
    Object lIndex(String key, long index);

    /**
     * 向List结构中添加属性
     *
     * @param key   key
     * @param value value
     * @return 增加后的长度
     */
    Long lPush(String key, Object value);

    /**
     * 向List结构中添加属性
     *
     * @param key   key
     * @param value value
     * @param time  过期时间
     * @return 增加后的长度
     */
    Long lPush(String key, Object value, long time);

    /**
     * 向List结构中批量添加属性
     *
     * @param key    key
     * @param values value 集合
     * @return 增加后的长度
     */
    Long lPushAll(String key, Object... values);

    /**
     * 向List结构中批量添加属性
     *
     * @param key    key
     * @param time   过期时间
     * @param values value集合
     * @return 增加后的长度
     */
    Long lPushAll(String key, Long time, Object... values);

    /**
     * 从List结构中移除属性
     *
     * @param key   key
     * @param count 总量
     * @param value value
     * @return 返回删除后的长度
     */
    Long lRemove(String key, long count, Object value);



    // ============================= Bitmap =============================

    /**
     * 向bitmap中新增值
     *
     * @param key    key
     * @param offset 偏移量
     * @param value  状态
     * @return 结果
     */
    Boolean bitSet(String key, int offset, boolean value);

    /**
     * 从bitmap中获取偏移量的值
     *
     * @param key    key
     * @param offset 偏移量
     * @return 结果
     */
    Boolean bitGet(String key, int offset);

    /**
     * 获取bitmap的key值总和
     *
     * @param key key
     * @return 总和
     */
    Long bitCount(String key);

    /**
     * 获取bitmap范围值
     *
     * @param key    key
     * @param limit  范围
     * @param offset 开始偏移量
     * @return long类型集合
     */
    List<Long> bitField(String key, int limit, int offset);

    /**
     * 获取所有bitmap
     *
     * @param key key
     * @return 以二进制字节数组返回
     */
    byte[] bitGetAll(String key);


    // ============================= GeoHash =============================

    /**
     * 增加坐标
     *
     * @param key  key
     * @param x    x
     * @param y    y
     * @param name 地点名称
     * @return 返回结果
     */
    Long geoAdd(String key, Double x, Double y, String name);

    /**
     * 根据城市名称获取坐标集合
     *
     * @param key   key
     * @param place 地点
     * @return 坐标集合
     */
    List<Point> geoGetPointList(String key, Object... place);

    /**
     * 计算两个城市之间的距离
     *
     * @param key      key
     * @param placeOne 地点1
     * @param placeTow 地点2
     * @return 返回距离
     */
    Distance geoCalculationDistance(String key, String placeOne, String placeTow);

    /**
     * 获取附该地点附近的其他地点
     *
     * @param key      key
     * @param place    地点
     * @param distance 附近的范围
     * @param limit    查几条
     * @param sort     排序规则
     * @return 返回附近的地点集合
     */
    GeoResults<RedisGeoCommands.GeoLocation<Object>> geoNearByPlace(String key, String place, Distance distance, long limit, Sort.Direction sort);

    /**
     * 获取地点的hash
     *
     * @param key   key
     * @param place 地点
     * @return 返回集合
     */
    List<String> geoGetHash(String key, String... place);
}
