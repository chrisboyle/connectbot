/*
 * ConnectBot: simple, powerful, open-source SSH client for Android
 * Copyright 2007 Kenny Root, Jeffrey Sharkey
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

package org.connectbot;

import org.connectbot.service.TerminalManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class LocaleReceiver extends BroadcastReceiver
{
	// Locale can't just use the Uri in the Intent; it stores everything as a bundle of extras
	public static final String EXTRA_URI = "org.connectbot.intent.extra.URI";

	// from locale_platform.jar
	private static final String ACTION_FIRE_SETTING = "com.twofortyfouram.locale.intent.action.FIRE_SETTING";

	@Override
	public void onReceive(final Context context, final Intent intent)
	{
		if (ACTION_FIRE_SETTING.equals(intent.getAction())) {
			final String u = intent.getStringExtra(EXTRA_URI);
			if (u == null) return;
			context.startService(new Intent(Intent.ACTION_VIEW, Uri.parse(u), context, TerminalManager.class));
		}
	}
}
