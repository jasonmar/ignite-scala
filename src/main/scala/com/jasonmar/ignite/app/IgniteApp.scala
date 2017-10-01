/*
 * Copyright 2017 Jason Mar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jasonmar.ignite.app

import com.jasonmar.ignite.Init
import com.jasonmar.ignite.util.AutoClose.autoCloseWithShutdownHook
import org.apache.ignite.Ignition

/** Used to create Ignite CLI applications
  */
trait IgniteApp extends IgniteFunction with IgniteInit {
  def main(args: Array[String]): Unit = {
    System.out.println(s"Initializing Ignite")
    Init(configs = igniteConfigs, cacheBuilders = cacheBuilders)
    autoCloseWithShutdownHook(Ignition.ignite()) {igniteFunction}
    System.out.println("exiting")
    System.exit(0)
  }
}