/**
 * MIT License
 *
 * Copyright (c) 2018 Tyler Wrenn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.tylerhyperhd.devandtesting;

import java.io.IOException;

public class DevLogger {

	private InstanceManager iMgr;

	/**
	 * Constructs the logger for the plugin
	 * @param iMgr The instance manager for the plugin
	 */
	public DevLogger(InstanceManager iMgr) {
		this.iMgr = iMgr;
	}

	/**
	 * Returns a log warning when needed
	 * @param msg The message of the log warning
	 */
	public void warning(String msg) {
		iMgr.getPlugin().getLogger().warning(msg);
	}

	/**
	 * Returns a log info when needed
	 * @param msg The message of the log info
	 */
	public void info(String msg) {
		iMgr.getPlugin().getLogger().warning(msg);
	}

	/**
	 * Returns a log warning when needed
	 * @param ex The message of the log warning
	 */
	public void warning(IOException ex) {
		iMgr.getPlugin().getLogger().warning(ex.toString());
	}

	/**
	 * Returns a log severe when needed
	 * @param msg The message of the log severe
	 */
	public void severe(String msg) {
		iMgr.getPlugin().getLogger().severe(msg);
	}

	/**
	 * Returns a log severe when needed
	 * @param ex The message of the log severe
	 */
	public void severe(Exception ex) {
		iMgr.getPlugin().getLogger().severe(ex.toString());
	}

}
