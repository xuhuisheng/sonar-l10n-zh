/*
 * L10n :: Chinese Pack
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
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
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.l10n;

import static org.junit.Assert.assertThat;
import static org.sonar.test.i18n.I18nMatchers.isBundleUpToDate;

import org.junit.Test;
import org.junit.Ignore;

public class ChinesePackPluginTest {

  private static final String SONAR_VERSION = "3.0.1";

  @Ignore
  @Test
  public void coreBundleShouldBeUpToDate() {
    assertThat("core_zh.properties", isBundleUpToDate(SONAR_VERSION));
  }

  @Ignore
  @Test
  public void gwtBundleShouldBeUpToDate() {
    assertThat("gwt_zh.properties", isBundleUpToDate(SONAR_VERSION));
  }

}
