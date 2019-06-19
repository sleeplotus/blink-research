package com.tiger.blink.streaming

import org.junit.Test
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time


/**
  * @author 王澎 2019-06-19
  */
class WindowWordCount {

  @Test
  def windowWordCount():Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.socketTextStream("localhost", 9999)

    val counts = text.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
                 .map { (_, 1) }
                 .keyBy(0)
                 .timeWindow(Time.seconds(5))
                 .sum(1)

    counts.print()

    env.execute("Window Stream WordCount")
  }

}
