package com.tiger.blink.batch

import org.apache.flink.api.scala._
import org.junit.Test

/**
  * @author Created by SleepLotus on 2019-06-20
  */
class WordCount {

  @Test
  def wordCount():Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val text = env.fromElements(
      "Who's there?",
      "I think I hear them. Stand, ho! Who's there?")

    val counts = text.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
                 .map { (_, 1) }
                 .groupBy(0)
                 .sum(1)

    counts.print()
  }

}
