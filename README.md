# Gamehub Revanced

![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/liaralabs/revanced-patches/release.yml)
![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)

## About

This is a small collection of patches to intended to allow the user to continue using Gamehub updates with a few key QoL improvements found in GameHub-Lite.

Patches currently include:
- Front-end Export (front-end emulation support)
  - Breaks apple/google login methods (won't fix)
- Enable debug mode (for app data access)
- Fix email logins (a new bug introduced in 5.3)

Has been tested against 5.3.2

## Get started

1. Get and install [ReVanced Manager](https://revanced.app/) on your device of choice
2. Enable "Use Alternative Sources" in ReVanced settings, as well as "Allow changing patch selection"
3. Change the "Alternative sources" repo organization from "revanced" to "liaralabs"
4. Restart the app, load in a fresh and untouched GameHub APK and away you go!

Please note, there are currently no guardrails on patch version compatibility. These patches are intended to be used against the latest available version of GameHub.

## Everything else

### 🛠️ Building

To build ReVanced Patches, you can follow the [ReVanced documentation](https://github.com/ReVanced/revanced-documentation).

## 📜 Licence

Gamehub ReVanced is licensed under the GPLv3 licence.
Please see the [license file](LICENSE) for more information.
[tl;dr](https://www.tldrlegal.com/license/gnu-general-public-license-v3-gpl-3) you may copy, distribute
and modify ReVanced Patches template as long as you track changes/dates in source files.
Any modifications to ReVanced Patches template must also be made available under the GPL,
along with build & install instructions.
