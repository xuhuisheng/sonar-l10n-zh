/*
 * L10n :: Chinese Pack
 * Copyright (C) 2014-2022 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
/*
 * L10n :: Japanese Pack
 * Forked and modified by Akito Moriki (C) 2025
 * - Changed to Japanese translation plugin
 */
package com.github.benishouga.sonar.plugins.l10n;

import org.sonar.api.Plugin;

import java.util.Collections;

public final class JapanesePackPlugin implements Plugin {

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

  @Override
  public void define(Context context) {
    context.addExtensions(Collections.emptyList());
  }
}
